package referidos

class Vacant {
    Integer id
    Recruiter recruiter
    Integer recruiterId
    String title
    String description
    String state
    Integer rewardAmount

    static hasMany = [postulations: Postulation]

    static constraints = {
        id unique: true
    }
}