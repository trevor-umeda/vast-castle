package com.imageCollect

class TagController {

    def tagImage() {
        def tag
        def image
        if (params.tag){
            tag = Tag.findOrCreateByName(params.tag)
            image = Image.findById(params.id)
        }
        else{
            tag = Tag.findOrCreateByName(request.JSON?.tag)
            image = Image.findById(request.JSON?.id)
        }
        image.addToTags(tag)
        image.save()

        render true
    }
}
