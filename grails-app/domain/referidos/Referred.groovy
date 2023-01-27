package referidos

class Referred {
    Integer dni
    String name
    String email
    String linkedin
    String city
    Employee employee
    Integer employeeId
    static hasMany = [postulations: Postulation]

    static constraints = {
        dni unique: true
    }
}
