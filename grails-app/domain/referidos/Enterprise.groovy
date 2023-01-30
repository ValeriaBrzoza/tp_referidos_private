package referidos

class Enterprise {
    String name
    Long cuit

    static hasMany = [employees: Employee]

    static constraints = {
        cuit unique: true
    }
}