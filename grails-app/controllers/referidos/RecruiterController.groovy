package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RecruiterController {

    RecruiterService recruiterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond recruiterService.list(params), model:[recruiterCount: recruiterService.count()]
    }

    def show(Long id) {
        respond recruiterService.get(id)
    }

    def create() {
        respond new Recruiter(params)
    }

    def save(Recruiter recruiter) {
        if (recruiter == null) {
            notFound()
            return
        }

        try {
            recruiterService.save(recruiter)
        } catch (ValidationException e) {
            respond recruiter.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), recruiter.id])
                redirect recruiter
            }
            '*' { respond recruiter, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond recruiterService.get(id)
    }

    def update(Recruiter recruiter) {
        if (recruiter == null) {
            notFound()
            return
        }

        try {
            recruiterService.save(recruiter)
        } catch (ValidationException e) {
            respond recruiter.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), recruiter.id])
                redirect recruiter
            }
            '*'{ respond recruiter, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        recruiterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'recruiter.label', default: 'Recruiter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
