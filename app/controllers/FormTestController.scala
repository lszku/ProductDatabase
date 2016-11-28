package controllers

import javax.inject.Inject

import model.{ExampleData, MarriedStatus}
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc.{Action, Controller, Flash}

/**
  * Created by lukas on 11/27/2016.
  */
class FormTestController @Inject()(val messagesApi: MessagesApi)
  extends Controller with I18nSupport {


  val exampleForm = Form(
    mapping(
      "id" -> longNumber,
      "name" -> text,
      "married" -> mapping(
        "ifMarried" -> boolean,
        "sinceThen" -> optional(date),
        "dateTo"->optional(date),
        "spouseId" -> optional(longNumber)
      )(MarriedStatus.apply)(MarriedStatus.unapply)
    )(ExampleData.apply)(ExampleData.unapply)
  )

  def formTest() = Action { implicit req =>
    Ok(views.html.examples.exampleDataDetails(exampleForm))
  }

  def saveController = Action { implicit req =>
    val newExampleForm = exampleForm.bindFromRequest()

    newExampleForm.fold(
      hasErrors = form => Redirect(routes.FormTestController.formTest()).flashing(Flash(form.data) +
        ("error" -> Messages("validation.error"))),
      example => {
        Redirect(routes.FormTestController.formTest()).flashing("success" -> example.toString)
      }
    )
  }

}
