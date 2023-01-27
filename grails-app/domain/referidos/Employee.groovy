package referidos

class Employee {
    Integer dni
    Long name
    Recruiter recruiter

    static hasMany = [referred: Referred, rewards: Reward]

    static constraints = {
        dni unique: true
    }
}