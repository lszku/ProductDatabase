package model


/**
  * Created by lukasz on 19.07.16.
  */
case class Product(ean: Long=0L,
                   name: String,
                   desc: String,
                   active: Boolean=true
                  ) {

}


object Product {
  def tupled = (Product.apply _).tupled
}


case class Warehouse(id: Long, name: String)

object Warehouse {
  def tupled = (Warehouse.apply _).tupled
}


case class StockItem(id: Long, productId: Long, warehouseId: Long, quantity: Long)

