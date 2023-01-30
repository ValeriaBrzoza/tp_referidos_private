package referidos

class Employee {
    Long dni
    String name
    Recruiter recruiter
    Enterprise enterprise

    static hasMany = [referred: Referred, rewards: Reward]

    static constraints = {
        dni unique: true
        recruiter nullable: true
    }
}