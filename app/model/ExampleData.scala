package model

import java.util.Date

/**
  * Created by lukas on 11/27/2016.
  */
case class ExampleData(
                        id: Long = 0L,
                        name: String,
                        marriedStatus: MarriedStatus
                      ) {
  override def toString = s"{$id, $name, $marriedStatus}"
}

case class MarriedStatus(
                          ifMarried: Boolean = false,
                          sinceThen: Option[Date] = None,
                          dateTo: Option[Date] = None,
                          spouseId: Option[Long] = Some(0)
                        ) {
  override def toString = s"{$ifMarried, $sinceThen, $spouseId}"
}