package com.imageCollect

class Image {

    String id
    String imageUrl
    
    static hasMany = [tags:Tag]

    static constraints = {

    }

    def json() {
        return [
                'id': id,
                'imageUrl': imageUrl,
                'tags':tags.collect{it.json()}
        ]

    }
}
