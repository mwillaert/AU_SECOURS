extends KinematicBody2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
const GRAVITY = 200.0


# Called when the node enters the scene tree for the first time.
func _ready():
	return


func _physics_process(delta):
	
	move_and_collide(Vector2(0, GRAVITY*delta))
	
	if Input.is_key_pressed(KEY_D):
		
		self.position += Vector2(128*delta, 0)
		
		return
	
	return
