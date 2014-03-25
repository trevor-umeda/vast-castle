package com.imageCollect

import grails.converters.JSON

class TagController {

    def tagImage() {
        def tag
        def image
        def tagName
        if (params.tag){
            tagName = params.tag.replaceAll(" ","")
            tag = Tag.findOrCreateByName(tagName)
            image = Image.findById(params.id)
        }
        else{
            tagName = params.tag.replaceAll(" ","")
            tag = Tag.findOrCreateByName(tagName)
            image = Image.findById(request.JSON?.id)
        }
        image.addToTags(tag)
        image.save()

        render true
    }
    def getTags(){
        def tags = Tag.all

        def tagNames =[]
        tags.each{
            tagNames += it.name
        }
        render tagNames as JSON

    }
    def sanitize(){
        def tags = Tag.all
        tags.each{
            it.name = it.name.replaceAll("_","")
            it.save(flush:true)
        }
        render true
    }
}
