package com.imageCollect

import grails.converters.JSON

class TagImageController {

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

        render true
    }  
}
