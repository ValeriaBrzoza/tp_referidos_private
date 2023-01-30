package referidos

class Vacant {
    Recruiter recruiter
    String title
    String description
    String state
    Integer rewardAmount

    static hasMany = [postulations: Postulation]
}