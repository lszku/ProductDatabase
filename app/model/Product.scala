package model

import play.api.libs.functional.syntax._
import play.api.libs.json._

/**
  * Created by lukasz on 19.07.16.
  */
case class Product(ean: Long = 0L,
                   name: String,
                   desc: String,
                   active: Boolean = true
                  ) {

}


object Product {
  def tupled = (Product.apply _).tupled

  implicit val productWrites: Writes[Product] = (
    (JsPath \ "ean").write[Long] and
      (JsPath \ "name").write[String] and
      (JsPath \ "desc").write[String] and
      (JsPath \ "active").write[Boolean]
    ) (unlift(Product.unapply))

  implicit val productReads: Reads[Product] = (
    (JsPath \ "ean").read[Long] and
      (JsPath \ "name").read[String] and
      (JsPath \ "desc").read[String] and
      (JsPath \ "active").read[Boolean]
    ) (Product.apply _)

}


case class Warehouse(id: Long, name: String)

object Warehouse {
  def tupled = (Warehouse.apply _).tupled
}


case class StockItem(id: Long, productId: Long, warehouseId: Long, quantity: Long)

