package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class FinancialInstitutionLoginChallenge extends Model {
	// autogenerated
    @Id public Long id; public Long getId() {return this.id;} public FinancialInstitutionLoginChallenge setId(Long id) {this.id = id; return this;}
    
    // has one FinancialInstitutionLogin 
    public Long financialInstitutionLoginId; public Long getFinancialInstitutionLoginId() {return this.financialInstitutionLoginId;} public FinancialInstitutionLoginChallenge setFinancialInstitutionLoginId(Long financialInstitutionLoginId) {this.financialInstitutionLoginId = financialInstitutionLoginId; return this;}
    public FinancialInstitutionLogin findFinancialInstitutionLogin() {return FinancialInstitutionLogin.find.ref(financialInstitutionLoginId);}
    
    // has one ChallengeQuestion
    public Long challengeQuestionId; public Long getChallengeQuestionId() {return this.challengeQuestionId;} public FinancialInstitutionLoginChallenge setChallengeQuestionId(Long challengeQuestionId) {this.challengeQuestionId = challengeQuestionId; return this;}
    public ChallengeQuestion findChallengeQuestion() {return ChallengeQuestion.find.ref(challengeQuestionId);}
    
    // has one ChallengeAnswer
    public Long challengeAnswerId; public Long getChallengeAnswerId() {return this.challengeAnswerId;} public FinancialInstitutionLoginChallenge setChallengeAnswerId(Long challengeAnswerId) {this.challengeAnswerId = challengeAnswerId; return this;}
    public ChallengeAnswer findChallengeAnswer() {return ChallengeAnswer.find.ref(challengeAnswerId);}
    
    public static FinancialInstitutionLoginChallenge create(Long financialInstitutionLoginId, Long questionId, Long answerId) {
        return (new FinancialInstitutionLoginChallenge()).setFinancialInstitutionLoginId(financialInstitutionLoginId).setChallengeQuestionId(questionId).setChallengeAnswerId(answerId).saveGet();
    }
    public FinancialInstitutionLoginChallenge saveGet() {this.save(); return this;}
    public static Finder<Long, FinancialInstitutionLoginChallenge> find = new Finder<Long, FinancialInstitutionLoginChallenge>(Long.class, FinancialInstitutionLoginChallenge.class);
}