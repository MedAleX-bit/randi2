package de.randi2.core.unit.model

import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before
import de.randi2.testUtility.utility.TestStringUtil
import de.randi2.model.Person

class PersonScalaTest extends AbstractDomainScalaTest {

  val person = new Person

  @Before
  def initialize() {

  }

  @Test
  def testTitelValueNullIsValid() { // Uses ScalaTest assertions
	  person.setTitle(null)
	  person.getTitle should be (null) // person.getTitel schould be valid with ("Beispiel")
	   									// person.getTitel schould be invalid with ("Beispiel")
  }

}