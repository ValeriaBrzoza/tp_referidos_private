package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostulationController {

    PostulationService postulationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postulationService.list(params), model:[postulationCount: postulationService.count()]
    }

    def show(Long id) {
        respond postulationService.get(id)
    }

    def create() {
        respond new Postulation(params)
    }

    def save(Postulation postulation) {
        if (postulation == null) {
            notFound()
            return
        }

        try {
            postulationService.save(postulation)
        } catch (ValidationException e) {
            respond postulation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postulation.label', default: 'Postulation'), postulation.id])
                redirect postulation
            }
            '*' { respond postulation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postulationService.get(id)
    }

    def update(Postulation postulation) {
        if (postulation == null) {
            notFound()
            return
        }

        try {
            postulationService.save(postulation)
        } catch (ValidationException e) {
            respond postulation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postulation.label', default: 'Postulation'), postulation.id])
                redirect postulation
            }
            '*'{ respond postulation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postulationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postulation.label', default: 'Postulation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postulation.label', default: 'Postulation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
