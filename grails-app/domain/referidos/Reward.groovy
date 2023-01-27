package referidos

class Reward {
    Integer id
    Integer amount
    Employee employee

    static constraints = {
        id unique: true
    }
}