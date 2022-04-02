extends KinematicBody2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
var velocity=Vector2(-50,50)

# Called when the node enters the scene tree for the first time.
func _ready():
	pass # Replace with function body.

func _physics_process(delta):
	
	move_and_collide(self.velocity*delta)
	

	
	return
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
