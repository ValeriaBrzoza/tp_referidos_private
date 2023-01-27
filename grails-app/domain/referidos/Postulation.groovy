package referidos

class Postulation {
    Referred referred
    Vacant vacant
    String state

    static constraints = {
        referred unique: true
        vacant unique: true
    }
}