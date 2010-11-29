package de.randi2.core.unit.model

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import de.randi2.model.Person
 
@RunWith(classOf[JUnitRunner])
class ScalaSpec extends Spec with ShouldMatchers {
    
	
	describe("A Person") {

    describe("(when new)") {

      val person = new Person

      it("should have an empty firstname") {
        person.getFirstname() should be ('empty)
      }
      
     it("should have an empty surname") {
        person.getSurname() should be ('empty)
      }

    }
  }
}