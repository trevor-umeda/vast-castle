package com.imageCollect

import grails.converters.*

class ImageController {

    Random random = new Random()

    def getImages() {
    	def images

    	if(params.tags){
    		def tag = Tag.findByName(params.tags)
    		images = tag.images
    	}
    	else{
    		images = Image.all
    	}
    	render images.collect{it.json()} as JSON
    }

    def createImage() {
        def image
        def imageUrl
        if(params.image){
            imageUrl = params.image
        }
        else{
            imageUrl = request.JSON?.image
        }

        image = new Image(imageUrl:imageUrl)
    	image.save(flush:true, failOnError: true)

    	render true
    }

    def getImage(){
        def tag = Tag.findByName(params.tag)
        if(tag){
            def images = tag.images
            def random = random.nextInt(images.size())
            def image = images[random]
            render image.imageUrl
         }
        else{
            render "No Image available"
        }

    }

    def health(){
        render "enabled"
    }

}
