# liftapp
This is app the to find out the nearest lift provision, from the clicked Floor Button details.

For ex:
there are 5 lifts are there in-process both upward and downward, If the request comes from any of the defined floor with the direction, then the
nearest lift has to be alloted to the reqqested floor.

Lift directions: upwared, downward, or empty ==> ideal. This lift details is the runtime details fetch dynamicall from database. Here it passed as a run-time environment variable
{
  "lifts": [
    {
      "liftNumber": 1,
      "direction": "upward",
      "currentFloor": 2
    },
    {
      "liftNumber": 2,
      "direction": "upward",
      "currentFloor": 5
    },
    {
      "liftNumber": 3,
      "direction": "downward",
      "currentFloor": 7
    },
    {
      "liftNumber": 4,
      "direction": "",
      "currentFloor": 1
    }
  ]
}


Lift button details is the static value from .property file.

Testcase 1:
if 2 lifs in upward direcation such as 1, 2 as a currentfloors for the each lift.
The button request comes from upward direction 6th floor. Then, the nearest lift2 will serve the purpose

TestCase 2:
There are 4 lifts are in operations, 2 are upwarrd, 1 is downward and 1 is in ideal state in Ground floor.
The currentFloors for the lifts are 2-Up, 5-Up, 7-Down, 1-ideal
if the request comes from 6th floor, downward, then 3rd lift should serve the service.
