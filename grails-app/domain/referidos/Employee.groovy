package referidos

class Employee {
    Long dni
    String name
    Recruiter recruiter

    static hasMany = [referred: Referred, rewards: Reward]

    static constraints = {
        dni unique: true
        recruiter nullable: true
    }
}