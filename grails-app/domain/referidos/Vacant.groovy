package referidos

class Vacant {
    Integer id
    Recruiter recruiter
    String title
    String description
    String state
    Integer rewardAmount

    static hasMany = [postulations: Postulation]

    static constraints = {
        id unique: true, generator: 'assigned'
    }
}