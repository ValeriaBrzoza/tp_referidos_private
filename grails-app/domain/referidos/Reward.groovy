package referidos

class Reward {
    Integer id
    Integer amount
    Employee employee
    Integer employeeId

    static constraints = {
        id unique: true
    }
}