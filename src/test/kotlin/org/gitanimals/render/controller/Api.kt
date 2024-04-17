package org.gitanimals.render.controller

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response

fun users(username: String): ExtractableResponse<Response> =
    RestAssured.given().log().all()
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .`when`().log().all()
        .get("/users/$username")
        .then().log().all()
        .extract()
