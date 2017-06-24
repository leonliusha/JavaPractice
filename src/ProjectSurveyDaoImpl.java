/*
 * WorkEffortDaoImpl.java  2010-6-18
 *
 ********************************************************************************
 *COPYRIGHT  AND  CONFIDENTIALITY  NOTICE 
 ********************************************************************************      
 *
 *Copyright (c) 2010 PriceWaterHouseCoopers GDC China. All rights reserved. 
 *This software contains valuable confidential and proprietary information of PwC GDC China and is subject to applicable licensing agreements.  
 *Unauthorized reproduction, transmission or distribution of this file and its contents is a violation of applicable laws.
 *
 */
//package net.mso.qualityportal.engagementsurvey.dao;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;

import net.mso.qualityportal.admin.model.Question;
import net.mso.qualityportal.admin.model.QuestionCategory;
import net.mso.qualityportal.common.dao.GenericJpaDaoImpl;
import net.mso.qualityportal.engagementsurvey.Constants;
import net.mso.qualityportal.engagementsurvey.model.ProjectSurvey;
import net.mso.qualityportal.engagementsurvey.model.ProjectSurveyScoreDto;
import net.mso.qualityportal.engagementsurvey.model.SurveyRating;
import net.mso.qualityportal.projectcenter.model.ProjectInfo;
import net.mso.qualityportal.projectcenter.model.ProjectMemberHist;

import org.hibernate.collection.PersistentSet;
import org.springframework.orm.jpa.JpaCallback;

/**
 * Class description goes here.
 * 
 * @version 1.0 2010-6-29
 * @author Gatsby Wang
 */
@SuppressWarnings("unchecked")
public class ProjectSurveyDaoImpl extends
        GenericJpaDaoImpl<ProjectSurvey, Long> implements ProjectSurveyDao {

    public ProjectSurveyDaoImpl() {
        super(ProjectSurvey.class);
    }

    public List<SurveyRating> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SurveyRating> findAllRatingByProject(Long projectId) {
        String jql = new StringBuilder().append("from ").append(SurveyRating.class.getName())
        .append(" where projectId = ?").toString();        
        
        return this.getJpaTemplate().find(jql, new Object[] {projectId});
    }    
    
    public List<Question> findAllQuestions() {
        
        return this.getJpaTemplate().find("from " + (Question.class).getName());
    }
    
    public List<QuestionCategory> findAllQuestionCategory() {
        
        return this.getJpaTemplate().find("from " + (QuestionCategory.class).getName());
    }

    public ProjectSurvey findProjectSurveyByURL(String url) {
        String jql = new StringBuilder().append("from ").append(ProjectSurvey.class.getName()).append(" where surveyURL = ?").toString();        
        List temp = this.getJpaTemplate().find(jql, new Object[] {url});
        if(temp!=null && temp.size()>0){
            return (ProjectSurvey)temp.get(0);
        }
        return null;
    }

    public ProjectInfo findProjectById(Long projectId) {
        String jql = new StringBuilder().append("from ").append(ProjectInfo.class.getName())
        .append(" where projectId = ?").toString();        
        List temp = this.getJpaTemplate().find(jql, new Object[] {projectId});
        if(temp!=null && temp.size()>0){
            return (ProjectInfo)temp.get(0);
        }
        return null;
    }

    public boolean existSurvey(ProjectSurvey survey) {
        StringBuilder sb = new StringBuilder("from ").append(ProjectSurvey.class.getName()).append(" ps where ps.surveyName = ?");
        List temp = this.getJpaTemplate().find(sb.toString(), survey.getSurveyName());

        if(survey.getProjectSurveyId() == null)
            return (temp == null || temp.size() == 0) ? false : true;
        else{
            if(temp==null) return false;
            else{
                if(temp.size() == 1){
                    if(survey.getProjectSurveyId().equals(((ProjectSurvey)temp.get(0)).getProjectSurveyId())){
                        return false;
                    }
                    return true;
                }
                else if (temp.size() == 0) return false;
                else return true;
            }
        }
    }

    
    public ProjectSurveyScoreDto calculateScore(final Long surveyId) {
        ProjectSurveyScoreDto surveyScoreDto = new ProjectSurveyScoreDto();
        
        
        // 1)calculate score for project questions.
        // 1.1)calculate average score for each question category.
        final String sql_projectQuestion = 
              "SELECT sr.avgScore, qc.categoryCode"
            + "  FROM ("
            + "       SELECT AVG(sr.ratingScore) AS avgScore, qc.categoryId"
            + "         FROM qp_surveyrating sr" 
            + "         JOIN qp_question q ON (sr.questionId = q.questionId)" 
            + "         JOIN qp_questioncategory qc ON (q.categoryId = qc.categoryId)" 
            + "        WHERE sr.surveyId = ? AND sr.ratingScore IS NOT NULL AND sr.ratingScore <> 0 AND qc.categoryCode <> 'Individual Survey'"
            + "        GROUP BY q.categoryId) sr"
            + " RIGHT JOIN (SELECT categoryId, categoryCode FROM qp_questioncategory qc" 
            + "              WHERE EXISTS (SELECT 1 FROM qp_surveyrating sc JOIN qp_question q ON (sc.questionId = q.questionId)"
            + "              WHERE sc.surveyId = ? AND q.categoryId = qc.categoryId AND sc.ratingScore IS NOT NULL) ) qc ON (sr.categoryId = qc.categoryId)"; 
        List<Object[]> list = this.getJpaTemplate().executeFind(
                new JpaCallback<List<Object[]>>() {
                    public List<Object[]> doInJpa(EntityManager em) {
                        return em.createNativeQuery(sql_projectQuestion)
                            .setParameter(1, surveyId)
                            .setParameter(2, surveyId)
                            .getResultList();
                    }
                }
        );

        BigDecimal overallScore = BigDecimal.ZERO;
        int count = 0;
        Map<String, BigDecimal> categoryScoreMap = new LinkedHashMap<String, BigDecimal>(list.size());
        for(Object[] objs: list) {
            if(objs[0] == null || BigDecimal.ZERO.equals(objs[0])) {
                categoryScoreMap.put( (String)objs[1], BigDecimal.ZERO );
                continue;
            }
            
            BigDecimal score = new BigDecimal(objs[0].toString());
            categoryScoreMap.put( (String)objs[1], score.setScale(2, BigDecimal.ROUND_HALF_UP) );
            overallScore  = overallScore.add(score);
            count++;
        }
        surveyScoreDto.setProjectCategoryScores( categoryScoreMap);
        
        // 1.2)calculate average score. 
        if(count > 0){
            overallScore = overallScore.divide(new BigDecimal(count), 2, BigDecimal.ROUND_HALF_UP);
        }
        surveyScoreDto.setProjectOverallScore(overallScore);
        
        
        // 2)calculate score for individual questions.
        // 2.1)calculate individual question score
        final String jql_individualQuestion = "select avg(sr.ratingScore), sr.question.questionId from " 
            + SurveyRating.class.getName() + " sr where sr.projectSurvey.projectSurveyId = ? " 
            + " and sr.ratingScore != 0 and sr.question.questionCategory.categoryCode = 'Individual Survey'" 
            + " group by sr.question.questionId";

        list = this.getJpaTemplate().find(jql_individualQuestion, new Object[] {surveyId} );

        overallScore = new BigDecimal(0);
        Map<Long, BigDecimal> scoreMap = new LinkedHashMap<Long, BigDecimal>(list.size());        
        for(Object[] objs: list) {
            BigDecimal score = new BigDecimal((Double)objs[0]);
            scoreMap.put( (Long)objs[1], score.setScale(2, BigDecimal.ROUND_HALF_UP) );
            overallScore  = overallScore.add(score);
        }
        surveyScoreDto.setIndividualCategoryScores( scoreMap);
        if(list!= null && list.size() >0){
            overallScore = overallScore.divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP);            
        }
        surveyScoreDto.setIndividualOverallScore(overallScore);

        // 2.2)for individual member score
        final String jql_individualMember = "select avg(sr.ratingScore), sr.portalUser.userId from " 
            + SurveyRating.class.getName() + " sr where sr.projectSurvey.projectSurveyId = ? " 
            + " and sr.ratingScore != 0 and sr.question.questionCategory.categoryCode = 'Individual Survey'" 
            + " group by sr.portalUser.userId";

        scoreMap = new LinkedHashMap<Long, BigDecimal>(list.size());
        list = this.getJpaTemplate().find(jql_individualMember, new Object[] {surveyId} );
        for(Object[] objs: list) {
            BigDecimal score = new BigDecimal((Double)objs[0]);
            scoreMap.put( (Long)objs[1], score.setScale(2, BigDecimal.ROUND_HALF_UP) );
        }
        surveyScoreDto.setIndividualMemberScores(scoreMap);
            
        return surveyScoreDto;
    }

    public List<ProjectSurvey> findSurveyByProject(Long projectId) {
        String jql = new StringBuilder().append("from ").append(ProjectSurvey.class.getName())
                        .append(" where projectId = ? and status = ? order by surveyDate desc").toString();        
        List temp = this.getJpaTemplate().find(jql, new Object[] {projectId, Constants.SURVEY_STATUS_COMPLETED});
        if(temp!=null && temp.size()>0){
            return temp;
        }
        return null;
    }

    public List<ProjectSurvey> getAllSurvey() {
    	List<ProjectSurvey> surveyList = new LinkedList<ProjectSurvey>();
    	 
        // modified by martin, 2010-11-11
        /*
        String jql = new StringBuilder().append("from ").append(ProjectSurvey.class.getName())
                .append(" where status != ? order by surveyDate asc").toString();
        List temp = this.getJpaTemplate().find(jql, Constants.SURVEY_STATUS_COMPLETED);
        */
        // modified by tian, 2013-7-17
//        surveyList.addAll(findUncompletedSurveys());
        
        String jql = new StringBuilder().append("from ").append(ProjectSurvey.class.getName())
            .append(" order by surveyDate desc").toString();
        List temp = this.getJpaTemplate().find(jql);
        surveyList.addAll(temp);
        
        return surveyList;
    }

    /*
     * (non-Javadoc)
     * @see net.mso.qualityportal.engagementsurvey.dao.ProjectSurveyDao#findUncompletedSurveys()
     */
    public List<ProjectSurvey> findUncompletedSurveys() {
        String jql = new StringBuilder().append("from ").append(ProjectSurvey.class.getName())
                .append(" where status != ? order by surveyDate desc").toString();
        return this.getJpaTemplate().find(jql, Constants.SURVEY_STATUS_COMPLETED);
    }
    
    public Set<ProjectMemberHist> findProjectMembers(final Long projectId) {
//    	final String sql = "select pm.projectId as projectId12_2_, " +
//    			"pm.projectMemberHistId as projectM1_2_, " +
//    			"pm.addOn as addOn15_1_, pm.userId as userId15_1_, " +
//    			"pm.projectId as projectId15_1_, pm.releaseOn as releaseOn15_1_," +
//    			"user.userId as userId1_0_, user.emailAddress as emailAdd9_1_0_, " +
//    			"user.firstName as firstName1_0_," +
//    			"user.lastName as lastName1_0_,user.middleName as middleName1_0_" +
//				" from qp_projectmember_hist pm left outer join user_ user on pm.userId=user.userId" +
//				" where pm.projectId=?";
    	
    	final String jql = "from ProjectMemberHist hist where hist.projectInfo.projectId = ?1";
    	List<ProjectMemberHist> hist = this.getJpaTemplate().find(jql, projectId);
    	
    	Set<ProjectMemberHist> projectMemberHist = new java.util.HashSet<ProjectMemberHist>();
    	for (int i = 0; i < hist.size(); i++) {
			projectMemberHist.add(hist.get(i));
		}
    	return projectMemberHist;
    }
}