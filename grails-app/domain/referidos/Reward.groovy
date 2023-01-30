package referidos

class Reward {
    Integer amount
    Employee employee

    static constraints = {
        id unique: true
    }
}