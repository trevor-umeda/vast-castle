package com.imageCollect

import grails.converters.JSON

class TagController {

static allowedMethods = [list:["GET","POST"], save: "POST", update: "POST", delete: "POST", search:"POST"]

def save() {
    def tag
    def image
    def tagName
    if (params.tag){
        tagName = params.tag
        tag = Tag.findOrCreateByName(tagName)
        if(params.imageUrl) {
          image = Image.findOrCreateByImageUrl(params.imageUrl)
        } else {
          image = Image.findById(params.id)
        }
    }
    else{
        tagName = params.tag.replaceAll(" ","")
        tag = Tag.findOrCreateByName(tagName)
        image = Image.findById(request.JSON?.id)
    }
    image.addToTags(tag)
    image.save()

    flash.message = "Successfully saved img: ${image.imageUrl} under tag: ${tag}"
    redirect(uri: "/")
}
    def search() {
      def tagName = params.tag
      def tag = Tag.findByName(tagName)
    
      if(tag) {
        redirect(uri:"/tagAdmin/show/${tag.id}")
      }
    }
    def tagImage() {
        def tag
        def image
        def tagName
        if (params.tag){
            tagName = params.tag
            tag = Tag.findOrCreateByName(tagName)
            if(params.imageUrl) {
              image = Image.findOrCreateByImageUrl(params.imageUrl)
            } else {
              image = Image.findById(params.id)
            }
        }
        else{
            tagName = params.tag.replaceAll(" ","")
            tag = Tag.findOrCreateByName(tagName)
            image = Image.findById(request.JSON?.id)
        }
        image.addToTags(tag)
        image.save()

        redirect(uri: "/")
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
