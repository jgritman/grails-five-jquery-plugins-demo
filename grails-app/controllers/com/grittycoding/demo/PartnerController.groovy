package com.grittycoding.demo

import org.springframework.dao.DataIntegrityViolationException

class PartnerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [partnerInstanceList: Partner.list(params), partnerInstanceTotal: Partner.count()]
    }

    def create() {
        [partnerInstance: new Partner(params)]
    }

    def save() {
        def partnerInstance = new Partner(params)
        if (!partnerInstance.save(flush: true)) {
            render(view: "create", model: [partnerInstance: partnerInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'partner.label', default: 'Partner'), partnerInstance.id])
        redirect(action: "show", id: partnerInstance.id)
    }

    def show() {
        def partnerInstance = Partner.get(params.id)
        if (!partnerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "list")
            return
        }

        [partnerInstance: partnerInstance]
    }

    def edit() {
        def partnerInstance = Partner.get(params.id)
        if (!partnerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "list")
            return
        }

        [partnerInstance: partnerInstance]
    }

    def update() {
        def partnerInstance = Partner.get(params.id)
        if (!partnerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (partnerInstance.version > version) {
                partnerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'partner.label', default: 'Partner')] as Object[],
                          "Another user has updated this Partner while you were editing")
                render(view: "edit", model: [partnerInstance: partnerInstance])
                return
            }
        }

        partnerInstance.properties = params

        if (!partnerInstance.save(flush: true)) {
            render(view: "edit", model: [partnerInstance: partnerInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'partner.label', default: 'Partner'), partnerInstance.id])
        redirect(action: "show", id: partnerInstance.id)
    }

    def delete() {
        def partnerInstance = Partner.get(params.id)
        if (!partnerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "list")
            return
        }

        try {
            partnerInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
