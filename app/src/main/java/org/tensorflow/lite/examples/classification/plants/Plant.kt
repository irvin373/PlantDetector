package org.tensorflow.lite.examples.classification.plants

class Plant(nameParam: String, groupParam: String, descriptionParam: String, uri: String) {
    val name: String = nameParam
    val group: String = groupParam
    val description: String = descriptionParam
    val img: String = uri
}