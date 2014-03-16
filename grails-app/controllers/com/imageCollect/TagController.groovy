package com.imageCollect

class TagController {

    def tagImage() {
        def tag = Tag.findOrCreateByName(request.JSON?.tag)
        def image = Image.findById(request.JSON?.id)

        image.addToTags(tag)
        image.save()

        render true
    }
}
