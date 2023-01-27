package referidos

class Enterprise {
    String name
    Long cuit

    static constraints = {
        cuit unique: true
    }
}