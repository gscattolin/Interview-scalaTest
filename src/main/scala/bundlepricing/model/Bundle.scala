package bundlepricing.model

/** A group of items offered at a discount */
case class Bundle(price: Dollars, items: NonEmptyMap[Item, Quantity])

object Bundle {
  def apply(price: Dollars, first: (Item, Quantity), rest: (Item, Quantity)*): Bundle =
    Bundle(price, NonEmptyMap(first, rest: _*))

  /** Define a "buy <X,...>, get <Y,...> free" bundle */
  def buyXgetYfree(buy: NonEmptyMap[Item, Quantity], getFree: NonEmptyMap[Item, Quantity]): Bundle =
    Bundle(undiscountedTotal(buy.toNel), buy |+| getFree)

  /** Define a "buy <X,...>, get <Y,...> free" bundle */
  def buyXgetYfree(buy: (Item, Quantity), andBuy: (Item, Quantity)*)
                  (getFree: (Item, Quantity), andGetFree: (Item, Quantity)*): Bundle =
    buyXgetYfree(NonEmptyMap(buy, andBuy: _*), NonEmptyMap(getFree, andGetFree: _*))
}