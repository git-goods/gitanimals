package org.gitanimals.render.controller

import org.gitanimals.render.app.UserFacade
import org.gitanimals.render.controller.request.ChangeFieldRequest
import org.gitanimals.render.controller.response.BackgroundResponse
import org.gitanimals.core.ErrorResponse
import org.gitanimals.core.FieldType
import org.gitanimals.core.auth.RequiredUserEntryPoints
import org.gitanimals.core.auth.UserEntryPoint
import org.gitanimals.render.domain.UserService
import org.gitanimals.render.domain.UserService.Companion.loadField
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BackgroundController(
    private val userFacade: UserFacade,
    private val userService: UserService,
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{username}/backgrounds")
    fun getBackgrounds(
        @PathVariable("username") username: String,
    ) = BackgroundResponse.from(userService.getByNameWithLazyLoading(username, loadField))

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/users/backgrounds")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun changeBackground(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestBody changeFieldRequest: ChangeFieldRequest,
    ) = userFacade.changeField(token, FieldType.valueOf(changeFieldRequest.type.uppercase()))

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/internals/backgrounds")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun addBackground(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam(name = "name") name: String,
    ) = userFacade.addField(token, FieldType.valueOf(name.uppercase()))


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/internals/backgrounds")
    @RequiredUserEntryPoints([UserEntryPoint.GITHUB])
    fun deleteBackground(
        @RequestHeader(HttpHeaders.AUTHORIZATION) token: String,
        @RequestParam(name = "name") name: String,
    ) = userFacade.deleteField(token, FieldType.valueOf(name.uppercase()))

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(illegalArgumentException: IllegalArgumentException): ErrorResponse =
        ErrorResponse.from(illegalArgumentException)
}
