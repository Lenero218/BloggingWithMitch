package com.example.bloggingapp.ui.main.create_blog.state

import android.net.Uri

data class CreateBlogViewState(
//Create Blog Fragment variable
var blogFeilds: NewBlogFields=NewBlogFields()


){
    data class NewBlogFields(
        var newBlogTitle:String?=null,
        var newBlogBody:String?=null,
        var newImageUri: Uri?=null
    )
}