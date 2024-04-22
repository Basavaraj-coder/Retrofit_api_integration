playing with Api's first you need to follow these steps

1) Add dependencies
//retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    //Json
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.google.code.gson:gson:2.10.1")

    //picasso
    implementation("com.squareup.picasso:picasso:2.71828")
2) add extension
Json to kotlin class

3) Create a data class/ POJO class/MODEL class from the 2nd step

4) Create a interface

5) create a Retrofit builder instance
6) get all data using enqueue(ctrl+shift+space for object callback method)
7) check response got or not in response and failure method