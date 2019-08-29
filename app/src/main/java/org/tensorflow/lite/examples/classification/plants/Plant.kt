package org.tensorflow.lite.examples.classification.plants

class Plant {
    private val name: String
    private val group: String
    constructor(name: String, group: String) {
        this.name = name
        this.group = group
    }
}