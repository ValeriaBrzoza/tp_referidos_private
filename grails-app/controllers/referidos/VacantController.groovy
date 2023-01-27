package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VacantController {

    VacantService vacantService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vacantService.list(params), model:[vacantCount: vacantService.count()]
    }

    def show(Long id) {
        respond vacantService.get(id)
    }

    def create() {
        respond new Vacant(params)
    }

    def save(Vacant vacant) {
        if (vacant == null) {
            notFound()
            return
        }

        try {
            vacantService.save(vacant)
        } catch (ValidationException e) {
            respond vacant.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vacant.label', default: 'Vacant'), vacant.id])
                redirect vacant
            }
            '*' { respond vacant, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vacantService.get(id)
    }

    def update(Vacant vacant) {
        if (vacant == null) {
            notFound()
            return
        }

        try {
            vacantService.save(vacant)
        } catch (ValidationException e) {
            respond vacant.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vacant.label', default: 'Vacant'), vacant.id])
                redirect vacant
            }
            '*'{ respond vacant, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vacantService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vacant.label', default: 'Vacant'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vacant.label', default: 'Vacant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
