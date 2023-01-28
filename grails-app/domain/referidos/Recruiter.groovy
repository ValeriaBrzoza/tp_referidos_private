package referidos

class Recruiter {
    static belongsTo = Employee

    static hasMany = [vacants: Vacant]
}