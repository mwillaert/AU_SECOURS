extends Node
export(PackedScene) var block_scene

var orientation=Vector2.UP

# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	pass
	
func _physics_process(delta):
	
	if Input.is_action_just_released("rotate"):
		$Player.orientation+=1
		$Player.orientation%=4



# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
