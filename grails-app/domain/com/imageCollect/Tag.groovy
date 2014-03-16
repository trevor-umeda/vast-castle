package com.imageCollect

class Tag {

	Integer id
	String name

	static belongsTo = Image
	static hasMany = [images:Image]
    static constraints = {
    }

    String toString(){
        name
    }

    def json() {
        return [
            "name": name
        ]
    }
}
