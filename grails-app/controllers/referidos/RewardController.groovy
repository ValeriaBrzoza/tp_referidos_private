package referidos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RewardController {

    RewardService rewardService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rewardService.list(params), model:[rewardCount: rewardService.count()]
    }

    def show(Long id) {
        respond rewardService.get(id)
    }

    def create() {
        respond new Reward(params)
    }

    def save(Reward reward) {
        if (reward == null) {
            notFound()
            return
        }

        try {
            rewardService.save(reward)
        } catch (ValidationException e) {
            respond reward.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reward.label', default: 'Reward'), reward.id])
                redirect reward
            }
            '*' { respond reward, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rewardService.get(id)
    }

    def update(Reward reward) {
        if (reward == null) {
            notFound()
            return
        }

        try {
            rewardService.save(reward)
        } catch (ValidationException e) {
            respond reward.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reward.label', default: 'Reward'), reward.id])
                redirect reward
            }
            '*'{ respond reward, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rewardService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reward.label', default: 'Reward'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reward.label', default: 'Reward'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
