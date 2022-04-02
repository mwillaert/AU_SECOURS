extends Node2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

var player_res = preload("res://scene/rect.tscn")


# Called when the node enters the scene tree for the first time.
func _ready():
	
	for i in range(10):
		
		var player = player_res.instance()
		player.position += Vector2(i * 64, 0)
		
		yield(get_tree().create_timer(1.0), "timeout")
		
		add_child(player)
		
		
	
	return


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
