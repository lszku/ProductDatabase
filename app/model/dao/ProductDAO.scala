package model.dao

import javax.inject.Inject

import model.Product
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import slick.lifted.{ProvenShape, TableQuery}

//import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by lukasz on 05.08.16.
  */
class ProductDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, implicit val executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  lazy val Products = TableQuery[ProductTable]

  import driver.api._

  class ProductTable(tag: Tag) extends Table[Product](tag, "products") {
    def ean = column[Long]("ean", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def desc = column[String]("descr")

    def * : ProvenShape[Product] = (ean, name, desc) <> (Product.tupled, Product.unapply)
  }


  def findByEan(ean: Long): Future[Seq[Product]] = db.run(Products.filter(_.ean === ean).result)

  def findByName(name: String): Future[Seq[Product]] = db.run(Products.filter(_.name === name).result)

  def findAll(): Future[Seq[Product]] = db.run(Products.sortBy(_.name.asc).result)

  def insert(product: Product): Future[Unit] = db.run(Products += product) map (_ => ())


  def delete(ean: Long): Future[Unit] =
    db.run(Products.filter(_.ean === ean).delete).
      map(_ => ())


}
