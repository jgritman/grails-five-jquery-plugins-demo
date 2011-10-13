import com.grittycoding.demo.*

class BootStrap {

    def init = { servletContext ->

    	def vmware = new Partner(name:"SpringSource",description:"Creator of the Spring Framework and related technologies.",website:"http://springsource.com").save()
    	def engineyard = new Partner(name:"Engine Yard",description:"Engine Yard has created a Ruby on Rails curriculum and we are partnering to deliver this training in our area.",website:"http://www.engineyard.com").save()
    	def typesafe = new Partner(name:"Typesafe",description:"Enterprise-Grade Scala from the Experts: Typesafe was founded in 2011 by the creators of the Scala programming language and Akka middleware, who joined forces to create a modern software platform for the era of multicore hardware and cloud computing workloads.",website:"http://www.typesafe.com").save()

    	def coreSpring = new Course(name:'Core Spring Developer Training/Certification',description:"Intensive introduction to the Spring 3.0 Framework.",days:4,basePrice:2790, partner:vmware).save()

    	def hibernateCourse = new Course(name:"Hibernate with Spring",description:"Learn to build ORM-based applications with Spring and the Hibernate ORM API. ",days:4,basePrice:2090,partner:vmware).save()

    	def enterpriseIntegration = new Course(name:"Enterprise Integration with Spring",description:"Deep dive into integration topics including SOAP and RESTful Web Services, messaging with JMS, transaction management, Spring Integration, Spring Batch and more.",days:3,basePrice:2790,partner:vmware).save()

    	def zeroToRails = new Course(name:"Zero to Rails 3.1",description:"Learn Ruby 1.9 and Rails 3.1 from the experts.",days:4,basePrice:1200,partner:engineyard).save()

    	def scalaCourse = new Course(name:"Fast Track to Scala",description:"This two-day course, designed by Martin Odersky, the creator of the Scala programming language, and Heiko Seeberger, a recognized Scala expert, will give you an excellent grounding in Scala.",days:2,basePrice:1750,partner:typesafe).save()

    	(new Class(course:coreSpring,startDate:Date.parse("dd-MM-yyyy","11-01-2011"))).save()

    	new Class(course:hibernateCourse,startDate:Date.parse("dd-MM-yyyy","30-11-2011")).save()

    	new Class(course:enterpriseIntegration,startDate:Date.parse("dd-MM-yyyy","11-11-2011")).save()

    	new Class(course:zeroToRails,startDate:Date.parse("dd-MM-yyyy","04-10-2011")).save()

    	new Class(course:scalaCourse,startDate:Date.parse("dd-MM-yyyy","04-10-2011")).save()

    }
    def destroy = {
    }
}
