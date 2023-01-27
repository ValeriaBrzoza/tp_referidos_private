package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReferredController {

    ReferredService referredService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond referredService.list(params), model:[referredCount: referredService.count()]
    }

    def show(Long id) {
        respond referredService.get(id)
    }

    def create() {
        respond new Referred(params)
    }

    def save(Referred referred) {
        if (referred == null) {
            notFound()
            return
        }

        try {
            referredService.save(referred)
        } catch (ValidationException e) {
            respond referred.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'referred.label', default: 'Referred'), referred.id])
                redirect referred
            }
            '*' { respond referred, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond referredService.get(id)
    }

    def update(Referred referred) {
        if (referred == null) {
            notFound()
            return
        }

        try {
            referredService.save(referred)
        } catch (ValidationException e) {
            respond referred.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'referred.label', default: 'Referred'), referred.id])
                redirect referred
            }
            '*'{ respond referred, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        referredService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'referred.label', default: 'Referred'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'referred.label', default: 'Referred'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
