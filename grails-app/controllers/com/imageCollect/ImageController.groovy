package com.imageCollect

import grails.converters.*

class ImageController {

    def getImages() {
    	def images

    	if(params.tags){
    		def tag = Tag.find(params.tags)
    		images = tag.images
    	}
    	else{
    		images = Image.all
    	}
    	render images.collect{it.json()} as JSON
    }

    def createImage() {
        def image
        if(params.image){
            image = new Image(imageUrl:params.image)
        }
        else{
            image = new Image(imageUrl:request.JSON?.image)
        }

    	image.save(flush:true, failOnError: true)

    	render true
    }


}
