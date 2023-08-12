package com.example.cardzap.models

class Card(
    var id: Int,
    var nameCard: String?,
    var department: String?,
    var company: String?,
    var imgAvatar: String?,
    var email: String?,
    var phoneNumber: String?,
    var webSite: String?,
    var address: String?,
    var facebook: String?,
    var linkin: String?,
    var instagram: String?
) {
    constructor(id: Int, nameCard: String?, imgAvatar: String?, email: String?) :
            this(id, nameCard, null, null, imgAvatar, email, null, null, null, null, null, null)
}